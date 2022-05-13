package dependency;

import activity.GetBookActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetBookActivity provideGetBookActivity();
}
