package com.epam.training.yuliya_azovtseva.framework.model;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EstimateModel {
    private String numberOfInstances;
    private String operatingSystem;
    private String provisioningModel;
    private String machineFamily;
    private String machineSeries;
    private String machineType;
    private String gpuModel;
    private String numberOfGpus;
    private String localSsd;
    private String region;
    private String commitedUse;
}