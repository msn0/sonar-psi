package com.github.msn0.sonar.quality.batch;

import com.github.msn0.sonar.quality.WebQualityMetric;
import com.github.msn0.sonar.quality.WebQualityPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

public class PsiSensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(PsiSensor.class);

    private Settings settings;

    public PsiSensor(Settings settings) {
        this.settings = settings;
    }

    public boolean shouldExecuteOnProject(Project project) {
        return true;
    }

    public void analyse(Project project, SensorContext sensorContext) {
        String value = settings.getString(WebQualityPlugin.PSI_REPORT_PATH);
        LOG.info(WebQualityPlugin.PSI_REPORT_PATH + "=" + value);
        sensorContext.saveMeasure(WebQualityMetric.PSI, Math.random() * 100);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
