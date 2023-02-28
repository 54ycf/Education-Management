import com.ecnu.office.OfficeApplication;
import com.ecnu.office.entity.Student;
import com.ecnu.office.mapper.OfficeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OfficeTest {

    @Autowired
//    OfficeMapper mapper;

    @Test
    public void testUpdateStudent(){
        Student student = new Student();
//        {
//            "id":1,
//                "sex":"男",
//                "stuNumber":"",
//                "name":"黄椒椒",
//                "inDate":"",
//                "outDate":"",
//                "department":"",
//                "email":"",
//                "phone":""
//        }

//        mapper.updateStudent();
    }
}
