package com.avatech.edi.codegen.model.bo;

import java.util.ArrayList;
import java.util.List;

public class BusinessObject {


    public static BusinessObject createBusinessObject(DomainModel model,ProjectInitial projectInitial){
        BusinessObject businessObject = new BusinessObject();
        businessObject.setApplicationName(projectInitial.getProjectName());
        businessObject.setBussinessObjectName(model.getModelName());
        businessObject.setBussinessObjectRepositoryPackageName(String.format("com.avatech.edi.%s.repository.%sRepository",projectInitial.getProjectName().toLowerCase(),model.getModelName()));
        businessObject.setBussinessObjectServicePackageName(String.format("com.avatech.edi.%s.service.%sService",projectInitial.getProjectName().toString(),model.getModelName()));
        for (Table table:model.getTableList()) {
            businessObject.getBussinessObjectModelPackageName().add(String.format("com.avatech.edi.%s.model.bo.%s.%s"
                    ,projectInitial.getProjectName()
                    ,model.getModelName().toLowerCase()
                    ,table.getTableProperty()));
        }
        return businessObject;
    }

    private String applicationName;

    private String bussinessObjectName;

    private List<String> bussinessObjectModelPackageName;

    private String bussinessObjectServicePackageName;

    private String bussinessObjectRepositoryPackageName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getBussinessObjectName() {
        return bussinessObjectName;
    }

    public void setBussinessObjectName(String bussinessObjectName) {
        this.bussinessObjectName = bussinessObjectName;
    }

    public List<String> getBussinessObjectModelPackageName() {
        if(bussinessObjectModelPackageName == null){
            bussinessObjectModelPackageName = new ArrayList<>();
        }
        return bussinessObjectModelPackageName;
    }

    public void setBussinessObjectModelPackageName(List<String> bussinessObjectModelPackageName) {
        this.bussinessObjectModelPackageName = bussinessObjectModelPackageName;
    }

    public String getBussinessObjectServicePackageName() {
        return bussinessObjectServicePackageName;
    }

    public void setBussinessObjectServicePackageName(String bussinessObjectServicePackageName) {
        this.bussinessObjectServicePackageName = bussinessObjectServicePackageName;
    }

    public String getBussinessObjectRepositoryPackageName() {
        return bussinessObjectRepositoryPackageName;
    }

    public void setBussinessObjectRepositoryPackageName(String bussinessObjectRepositoryPackageName) {
        this.bussinessObjectRepositoryPackageName = bussinessObjectRepositoryPackageName;
    }
}
