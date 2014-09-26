package com.github.msn0.sonar.quality.ui;

import org.sonar.api.web.Footer;

public final class WidgetFooter implements Footer {

    public String getHtml() {
        return "<p>Footer Example - <em>This is static HTML</em></p>";
    }
}
