package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.ProductImage;
import ra.repository.ProductImageRepository;
import ra.service.ProductImagesService;
@Service
public class ProductImagesServiceImp implements ProductImagesService {
    @Autowired
    private ProductImageRepository productImageRepository;
    @Override
    public boolean save(ProductImage productImage) {
        ProductImage productImageNew = productImageRepository.save(productImage);
        return productImageNew != null ? true : false;
    }
}
