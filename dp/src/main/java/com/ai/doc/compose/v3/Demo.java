package com.ai.doc.compose.v3;

import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class Demo {
    private static final long ORGANIZATION_ROOT_ID = 1001;
    private DepartmentRepo departmentRepo;//依赖注入
    private EmployeeRepo employeeRepo;//依赖注入
    
    public void buildOrganization(){
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }
    
    private void buildOrganization(Department department){
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department);
        for (Long subDepartmentId:subDepartmentIds){
            Department subDepartment = new Department(subDepartmentId);
            department.addSunNode(subDepartment);
            buildOrganization(subDepartment);
        }
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId:employeeIds){
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSunNode(new Employee(employeeId,salary));
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
