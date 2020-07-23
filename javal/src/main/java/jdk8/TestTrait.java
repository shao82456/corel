package jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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

class AlertingDemo implements Alerting {
    private Map<String, String> _params;

    AlertingDemo(Map<String, String> params) {
        _params=params;
    }

    @Override
    public String get(String key) {
        if(!_params.containsKey(key)){
            throw new NoSuchElementException(key);
        }
        return _params.get(key);
    }
    @Override
    public String confPrefix() {
        return "spark.alert.test.";
    }
}

public class TestTrait{
    public static void main(String[] args) {
        Map<String,String> params=new HashMap<>();
        params.put("spark.alert.test.mail","123");
        AlertClient sa=new AlertingDemo(params).alerter();
        System.out.println("...");
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