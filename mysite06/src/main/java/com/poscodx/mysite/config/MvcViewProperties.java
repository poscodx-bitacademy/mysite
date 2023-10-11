package com.poscodx.mysite.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.mvc.view")
public class MvcViewProperties {
	private String prefix;
	private String suffix;
	private boolean exposeContextBeansAsAttributes;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public boolean isExposeContextBeansAsAttributes() {
		return exposeContextBeansAsAttributes;
	}
	public void setExposeContextBeansAsAttributes(boolean exposeContextBeansAsAttributes) {
		this.exposeContextBeansAsAttributes = exposeContextBeansAsAttributes;
	}
}
