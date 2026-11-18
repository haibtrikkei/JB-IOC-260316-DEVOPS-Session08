package ra.demo.init_data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;
import ra.demo.common.StatusType;
import ra.demo.model.entity.Category;
import ra.demo.repository.CategoryRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitCategory implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("InitCategory is running...");
        // Add your initialization logic here
        if(!categoryRepository.findAll().isEmpty()) {
            return;
        }
        List<Category> categories = List.of(
                new Category(null, "Electronics", "Electronic devices and gadgets", StatusType.ACTIVE, null),
                new Category(null, "Books", "Various genres of books", StatusType.ACTIVE, null),
                new Category(null, "Clothing", "Apparel and fashion items", StatusType.ACTIVE, null)
        );
        categoryRepository.saveAll(categories);
    }
}
