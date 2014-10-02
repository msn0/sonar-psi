package com.github.msn0.sonar.quality.batch;

import com.github.msn0.sonar.quality.WebQualityMetrics;
import com.github.msn0.sonar.quality.WebQualityPlugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.Project;

import java.io.FileReader;

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
        String reportPath = settings.getString(WebQualityPlugin.PSI_REPORT_PATH);
        LOG.info("Attempt to analyse " + WebQualityPlugin.PSI_REPORT_PATH + "=" + reportPath);
        JSONParser parser = new JSONParser();
        try {
            Object json = parser.parse(new FileReader(reportPath));
            JSONObject jsonObject = (JSONObject) json;
            sensorContext.saveMeasure(WebQualityMetrics.SCORE, Double.valueOf((Long) jsonObject.get("score")));
            sensorContext.saveMeasure(WebQualityMetrics.HTML_RESPONSE, Double.valueOf((Double) jsonObject.get("html-response")));
            sensorContext.saveMeasure(WebQualityMetrics.CSS_RESPONSE, Double.valueOf((Double) jsonObject.get("css-response")));
            sensorContext.saveMeasure(WebQualityMetrics.JAVASCRIPT_RESPONSE, Double.valueOf((Double) jsonObject.get("javascript-response")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
