package jdk8;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: shaoff
 * Date: 2020/3/10 16:23
 * Package: jdk8
 * Description:
 * scala trait 在java中的写法
 * trait Alerting {
 * protected val confPrefix = "spark.alert."
 * <p>
 * def get(key: String): String
 * <p>
 * val alerter: AlertClient = AlertClient.builder()
 * .mail(get(confPrefix + "mail"))
 * .ding(get(confPrefix + "ding"))
 * .mobile(get(confPrefix + "mobile"))
 * .build()
 * }
 * <p>
 * case class SimpleAlerter(params:Map[String,String]) extends Alerting{
 * override def get(key: String): String = params(key)
 * }
 */


interface Alerting {
    default String confPrefix() {
        return "spark.alert.";
    }
    String get(String key);
    default AlertClient alerter() {
        return AlertClient.builder().mail(get(confPrefix() + "mail")).build();
    }
}

public class Trait implements Alerting {
    private Map<String, String> _params;

    void Trail(Map<String, String> params) {
        _params=params;
    }

    @Override
    public String get(String key) {
        return _params.get(key);
    }

    public static void main(String[] args) {
        System.out.println("...");
        Trait t=new Trait();
    }
}

class AlertClient {
    public AlertClient(String mail, String ding, String mobile) {
    }

    static AlertClientBuilder builder() {
        return new AlertClientBuilder();
    }

    static class AlertClientBuilder {
        private String mail;
        private String ding;
        private String mobile;

        AlertClientBuilder mail(String _mail) {
            this.mail = _mail;
            return this;
        }

        AlertClientBuilder ding(String _ding) {
            this.ding = _ding;
            return this;
        }

        AlertClientBuilder mobile(String _mobile) {
            this.mobile = _mobile;
            return this;
        }

        AlertClient build() {
            return new AlertClient(mail, ding, mobile);
        }
    }
}