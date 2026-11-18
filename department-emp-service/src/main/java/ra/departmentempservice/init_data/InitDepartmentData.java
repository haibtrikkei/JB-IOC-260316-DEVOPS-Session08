package ra.departmentempservice.init_data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ra.departmentempservice.entity.Department;
import ra.departmentempservice.entity.Status;
import ra.departmentempservice.repository.DepartmentRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDepartmentData implements CommandLineRunner {
    private final DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if(!departmentRepository.findAll().isEmpty()) {
            return;
        }

        List<Department> departments = List.of(
            new Department(null,"Phòng nhân sự","Phòng quản lý nhân sự", Status.ACTIVE),
            new Department(null,"Phòng kế toán","Phòng quản lý nhân sự kế toán", Status.ACTIVE),
            new Department(null,"Phòng giám đốc","Phòng lãnh đạo công ty", Status.ACTIVE),
            new Department(null,"Phòng marketing","Phòng quản lý nhân sự marketing", Status.ACTIVE)
        );

        departmentRepository.saveAll(departments);
    }
}
