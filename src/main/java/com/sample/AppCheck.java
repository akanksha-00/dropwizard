package com.sample;

import com.codahale.metrics.health.HealthCheck;
import com.sample.data.Person;
import com.sample.persistence.PersonDB;

public class AppCheck extends HealthCheck {

    private final String version;

    public AppCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception{
        if(PersonDB.getCount() == 0){
            return Result.unhealthy("No persons in DB! version: " + this.version);
        }
        return Result.healthy("OK with version: " + this.version + ". Persons count: " + PersonDB.getCount());
    }



}
