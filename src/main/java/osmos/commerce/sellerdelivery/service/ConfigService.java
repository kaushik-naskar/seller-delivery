package osmos.commerce.sellerdelivery.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import osmos.commerce.sellerdelivery.dto.CSVModel;
import osmos.commerce.sellerdelivery.dto.Item;
import osmos.commerce.sellerdelivery.entity.OrderEntity;
import osmos.commerce.sellerdelivery.entity.SellerEntity;
import osmos.commerce.sellerdelivery.exception.NotFoundException;
import osmos.commerce.sellerdelivery.mapper.CSVModelMapper;
import osmos.commerce.sellerdelivery.repository.OrderRepository;
import osmos.commerce.sellerdelivery.repository.SellerRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConfigService {

    @Autowired
    private CSVModelMapper csvModelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional
    public void uploadOrders(MultipartFile file) {

        if (file.isEmpty()) {
            throw NotFoundException.fileNotFoundException("File not found");
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                CsvToBean<CSVModel> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CSVModel.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<CSVModel> csvModelList = csvToBean.parse();
                Map<String, List<CSVModel>> sellerToOrder = csvModelList.stream().collect(Collectors.groupingBy(CSVModel::getStoreName));
                saveIntoDB(sellerToOrder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveIntoDB(Map<String, List<CSVModel>> sellerToOrder) {
        sellerToOrder.forEach((key, value) -> {
            SellerEntity sellerEntity = csvModelMapper.mapToSellerEntity(value.get(0));
            sellerEntity = sellerRepository.save(sellerEntity);
            Integer sellerId = sellerEntity.getId();
            Map<String, List<CSVModel>> customerToOrder = value.stream().collect(Collectors.groupingBy(CSVModel::getCustomerName));
            List<OrderEntity> orderEntities = customerToOrder.values().stream().map(csvModels -> {
                OrderEntity orderEntity = csvModelMapper.mapToOrderEntity(value.get(0), sellerId);
                List<Item> items = csvModelMapper.mapToItems(csvModels);
                orderEntity.setItems(items);
                return orderEntity;
            }).collect(Collectors.toList());
            orderRepository.saveAll(orderEntities);
        });
    }
}
