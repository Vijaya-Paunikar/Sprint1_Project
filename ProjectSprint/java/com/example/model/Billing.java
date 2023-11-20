package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Billing 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingId;

    private Long customerId;
    private Long serviceId;
    private Double cost;
    private String invoiceStatus;
    private String paymentStatus;
    private Date paymentDueDate;
    private String paymentMethod;

    // Constructors, getters, and setters

    // Constructors
    public Billing() {
        // Default constructor
    }

    public Billing(Long customerId, Long serviceId, Double cost, String invoiceStatus,
                   String paymentStatus, Date paymentDueDate, String paymentMethod) {
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.cost = cost;
        this.invoiceStatus = invoiceStatus;
        this.paymentStatus = paymentStatus;
        this.paymentDueDate = paymentDueDate;
        this.paymentMethod = paymentMethod;
    }

    // Getters and setters

    public Long getBillingId() {
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

