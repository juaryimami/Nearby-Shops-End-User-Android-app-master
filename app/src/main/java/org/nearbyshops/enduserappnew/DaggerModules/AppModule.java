package org.nearbyshops.enduserappnew.DaggerModules;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import org.nearbyshops.enduserappnew.MyApplication;

import javax.inject.Singleton;


@Module
public class AppModule {

    MyApplication mApplication;

    public AppModule(MyApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

}
