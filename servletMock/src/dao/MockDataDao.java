package dao;

import pojo.MockContent;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDataDao {

    public static final Map<String , MockContent> MockData =
            new HashMap<>();
//解决性能问题，不通过迭代连表去实现

    public void addMockData(String key,MockContent mockContent){
        MockData.put(key,mockContent);

    }

    public void deleteMockData(String key){
        MockData.remove(key);

    }

    public void updateMockData(String key,MockContent mockContent){
        MockData.put(key,mockContent);

    }

    public MockContent getMockData(String key){
        return MockData.get(key);
    }

    public List<MockContent> getAllMockData(){
        return Collections.list(Collections.enumeration(MockData.values()));

    }
}


