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

            LOG.debug("Analysis of " + jsonObject);

            sensorContext.saveMeasure(WebQualityMetrics.SCORE,
                    Double.valueOf((Long) jsonObject.get("score")));

            sensorContext.saveMeasure(WebQualityMetrics.HTML_RESPONSE_BYTES,
                    Double.valueOf((String) getPageStats(jsonObject).get("htmlResponseBytes")));
            sensorContext.saveMeasure(WebQualityMetrics.CSS_RESPONSE_BYTES,
                    Double.valueOf((String) getPageStats(jsonObject).get("cssResponseBytes")));
            sensorContext.saveMeasure(WebQualityMetrics.IMAGE_RESPONSE_BYTES,
                    Double.valueOf((String) getPageStats(jsonObject).get("imageResponseBytes")));
            sensorContext.saveMeasure(WebQualityMetrics.JAVASCRIPT_RESPONSE_BYTES,
                    Double.valueOf((String) getPageStats(jsonObject).get("javascriptResponseBytes")));
            sensorContext.saveMeasure(WebQualityMetrics.OTHER_RESPONSE_BYTES,
                    Double.valueOf((String) getPageStats(jsonObject).get("otherResponseBytes")));
            sensorContext.saveMeasure(WebQualityMetrics.TOTAL_REQUEST_BYTES,
                    Double.valueOf((String) getPageStats(jsonObject).get("totalRequestBytes")));

            sensorContext.saveMeasure(WebQualityMetrics.NUMBER_RESOURCES,
                    Double.valueOf((Long) getPageStats(jsonObject).get("numberResources")));
            sensorContext.saveMeasure(WebQualityMetrics.NUMBER_HOSTS,
                    Double.valueOf((Long) getPageStats(jsonObject).get("numberHosts")));
            sensorContext.saveMeasure(WebQualityMetrics.NUMBER_STATIC_RESOURCES,
                    Double.valueOf((Long) getPageStats(jsonObject).get("numberStaticResources")));
            sensorContext.saveMeasure(WebQualityMetrics.NUMBER_JS_RESOURCES,
                    Double.valueOf((Long) getPageStats(jsonObject).get("numberJsResources")));
            sensorContext.saveMeasure(WebQualityMetrics.NUMBER_CSS_RESOURCES,
                    Double.valueOf((Long) getPageStats(jsonObject).get("numberCssResources")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    private JSONObject getPageStats (JSONObject jsonObject) {
        return (JSONObject) jsonObject.get("pageStats");
    }

}
