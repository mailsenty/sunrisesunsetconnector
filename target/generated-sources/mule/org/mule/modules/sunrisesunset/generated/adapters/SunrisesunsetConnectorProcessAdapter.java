
package org.mule.modules.sunrisesunset.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.sunrisesunset.SunrisesunsetConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>SunrisesunsetConnectorProcessAdapter</code> is a wrapper around {@link SunrisesunsetConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-03T03:22:16-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class SunrisesunsetConnectorProcessAdapter
    extends SunrisesunsetConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<SunrisesunsetConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, SunrisesunsetConnectorCapabilitiesAdapter> getProcessTemplate() {
        final SunrisesunsetConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,SunrisesunsetConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, SunrisesunsetConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, SunrisesunsetConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
