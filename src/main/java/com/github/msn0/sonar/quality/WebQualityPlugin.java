package com.github.msn0.sonar.quality;

import com.github.msn0.sonar.quality.batch.PsiSensor;
import com.github.msn0.sonar.quality.ui.RubyWidget;
import com.github.msn0.sonar.quality.ui.WidgetFooter;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import java.util.Arrays;
import java.util.List;

@Properties({
        @Property(
                key = WebQualityPlugin.PSI_REPORT_PATH,
                name = "Plugin Property",
                description = "A property for the plugin",
                defaultValue = "Hello World!")})
public final class WebQualityPlugin extends SonarPlugin {

    public static final String PSI_REPORT_PATH = "sonar.webquality.psi.report";

    public List getExtensions() {
        return Arrays.asList(
                WebQualityMetric.class,
                PsiSensor.class,
                WidgetFooter.class,
                RubyWidget.class
        );
    }
}
