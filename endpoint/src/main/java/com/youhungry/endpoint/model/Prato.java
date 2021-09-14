package com.youhungry.endpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Prato {
}
