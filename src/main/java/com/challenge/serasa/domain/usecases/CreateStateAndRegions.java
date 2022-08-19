package com.challenge.serasa.domain.usecases;

public interface CreateStateAndRegions {

    Boolean create(String region, String[] states) throws Exception;

}
