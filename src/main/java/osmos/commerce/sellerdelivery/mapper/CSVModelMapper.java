package osmos.commerce.sellerdelivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import osmos.commerce.sellerdelivery.dto.CSVModel;
import osmos.commerce.sellerdelivery.dto.Item;
import osmos.commerce.sellerdelivery.entity.OrderEntity;
import osmos.commerce.sellerdelivery.entity.SellerEntity;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CSVModelMapper {

    @Mapping(source = "storeName", target = "name")
    @Mapping(source = "storeLocality", target = "locality")
    @Mapping(source = "storeAddress", target = "address")
    @Mapping(source = "srcLat", target = "position.latitude")
    @Mapping(source = "srcLong", target = "position.longitude")
    SellerEntity mapToSellerEntity(CSVModel csvModel);


    @Mapping(source = "csvModel.destLat", target = "position.latitude")
    @Mapping(source = "csvModel.destLong", target = "position.longitude")
    @Mapping(source = "csvModel.customerName", target = "customer.name")
    @Mapping(source = "csvModel.customerMobile", target = "customer.mobileNumber")
    @Mapping(source = "csvModel.customerMobile", target = "customer.locality")
    @Mapping(source = "csvModel.customerAddress", target = "customer.address")
    OrderEntity mapToOrderEntity(CSVModel csvModel, Integer sellerId);


    List<Item> mapToItems(List<CSVModel> csvModels);

    @Mapping(source = "productName", target = "name")
    Item mapToItem(CSVModel csvModel);

}
