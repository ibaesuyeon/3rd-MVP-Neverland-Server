package depth.mvp.thinkerbell.domain.common.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class CategoryService {

    private Map<String, String> categoryMap1;
    private Map<String, String> categoryMap2;

    public CategoryService() {
        loadCategoryMap();
        upperCategoryMap();
    }

    private void loadCategoryMap() {
        ObjectMapper objectMapper = new ObjectMapper();

        try(InputStream inputStream = new ClassPathResource("Categories.json").getInputStream()) {
            categoryMap1 = objectMapper.readValue(inputStream, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            throw new RuntimeException("카테고리 메핑 파일을 로드하는 동안 오류가 발생했습니다.",e);
        }
    }

    private void upperCategoryMap() {
        ObjectMapper objectMapper = new ObjectMapper();

        try(InputStream inputStream = new ClassPathResource("Category.json").getInputStream()) {
            categoryMap2 = objectMapper.readValue(inputStream, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            throw new RuntimeException("카테고리 메핑 파일을 로드하는 동안 오류가 발생했습니다.",e);
        }
    }

    public String getCategoryNameInKorean(String category) {
        return categoryMap1.getOrDefault(category, category);
    }
    public String getCategoryUpper(String category) {
        return categoryMap2.getOrDefault(category, category);
    }
}
