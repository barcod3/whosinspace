package uw.whosinspace

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.assets.AssetsBundle

class SpaceApplication extends Application<SpaceConfiguration> {

    @Override
    String getName() {
        'whos-in-space'
    }

    @Override
    void initialize(Bootstrap<SpaceConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle('/assets', '/ui', 'index.html'))
    }

    @Override
    void run(SpaceConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new SpaceResource())
        environment.jersey().register(new ReadsResource())
    }
}
