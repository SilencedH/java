package net.youzule.youzule.common.other;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/6/12 17:21
 **/

public class Ip implements Serializable {
    private static final Long serialVersionUID = 1L;
    /**
     * ip
     **/
    private String ip;
    /**
     * 国家
     **/
    private String country;
    /**
     * 省
     **/
    private String area;
    /**
     *
     **/
    private String region;
    /**
     *
     **/
    private String city;
    /**
     *
     **/
    private String county;
    /**
     * 运营商
     **/
    private String isp;
    /**
     * countryId
     **/
    private String countryId;
    /**
     *
     **/
    private String areaId;
    /**
     * regionId
     **/
    private String regionId;
    /**
     * cityId
     **/
    private String cityId;
    /**
     * countyId
     **/
    private String countyId;
    /**
     * ispId
     **/
    private String ispId;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getCountryId() {
        return countryId;
    }

    @JSONField(name = "country_id")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getAreaId() {
        return areaId;
    }

    @JSONField(name = "area_id")
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRegionId() {
        return regionId;
    }

    @JSONField(name = "region_id")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getCityId() {
        return cityId;
    }

    @JSONField(name = "city_id")
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    @JSONField(name = "county_id")
    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getIspId() {
        return ispId;
    }

    @JSONField(name = "isp_id")
    public void setIspId(String ispId) {
        this.ispId = ispId;
    }
}

