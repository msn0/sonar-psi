package com.github.msn0.sonar.quality;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.Arrays;
import java.util.List;

public final class WebQualityMetric implements Metrics {

    public static final Metric PSI = new Metric.Builder("psi", "Page Speed Index", Metric.ValueType.INT)
            .setDescription("Page Speed Index (PSI)")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(true)
            .setDomain(CoreMetrics.DOMAIN_GENERAL)
            .setBestValue(100d)
            .setWorstValue(0d)
            .create();

    public List<Metric> getMetrics() {
        return Arrays.asList(PSI);
    }
}
