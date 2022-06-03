package com.sample;

import com.sample.configuration.AppConfiguration;
import com.sample.service.PersonService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class RestApplication extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception{
        new RestApplication().run(args);
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment){

        final PersonService personService = new PersonService();
        environment.jersey().register(personService);

        environment.healthChecks().register("template", new AppCheck(configuration.getVersion()));

    }

}
