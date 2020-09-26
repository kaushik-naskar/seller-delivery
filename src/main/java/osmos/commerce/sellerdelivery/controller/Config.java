package osmos.commerce.sellerdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import osmos.commerce.sellerdelivery.service.ConfigService;

@RestController
@RequestMapping("/config")
public class Config {

    @Autowired
    private ConfigService configService;

    @RequestMapping("/upload-orders")
    public ResponseEntity<Void> uploadOrders(@RequestParam("file") MultipartFile file){
        configService.uploadOrders(file);
        return ResponseEntity.accepted().build();
    }
}
