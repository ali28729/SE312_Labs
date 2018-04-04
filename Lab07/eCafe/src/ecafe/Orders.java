/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecafe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Orders.findByTime", query = "SELECT o FROM Orders o WHERE o.time = :time")
    , @NamedQuery(name = "Orders.findByType", query = "SELECT o FROM Orders o WHERE o.type = :type")
    , @NamedQuery(name = "Orders.findByCompletionStatus", query = "SELECT o FROM Orders o WHERE o.completionStatus = :completionStatus")})
public class Orders implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "completion_status")
    private String completionStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderHistory> orderHistoryCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User customerId;
    @JoinColumn(name = "dish_id", referencedColumnName = "dish_id")
    @ManyToOne(optional = false)
    private Menu dishId;

    public Orders() {
    }

    public Orders(Integer orderId) {
        this.orderId = orderId;
    }

    public Orders(Integer orderId, Date time, String type, String completionStatus) {
        this.orderId = orderId;
        this.time = time;
        this.type = type;
        this.completionStatus = completionStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        Integer oldOrderId = this.orderId;
        this.orderId = orderId;
        changeSupport.firePropertyChange("orderId", oldOrderId, orderId);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        Date oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        String oldType = this.type;
        this.type = type;
        changeSupport.firePropertyChange("type", oldType, type);
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        String oldCompletionStatus = this.completionStatus;
        this.completionStatus = completionStatus;
        changeSupport.firePropertyChange("completionStatus", oldCompletionStatus, completionStatus);
    }

    @XmlTransient
    public Collection<OrderHistory> getOrderHistoryCollection() {
        return orderHistoryCollection;
    }

    public void setOrderHistoryCollection(Collection<OrderHistory> orderHistoryCollection) {
        this.orderHistoryCollection = orderHistoryCollection;
    }

    public User getCustomerId() {
        return customerId;
    }

    public void setCustomerId(User customerId) {
        User oldCustomerId = this.customerId;
        this.customerId = customerId;
        changeSupport.firePropertyChange("customerId", oldCustomerId, customerId);
    }

    public Menu getDishId() {
        return dishId;
    }

    public void setDishId(Menu dishId) {
        Menu oldDishId = this.dishId;
        this.dishId = dishId;
        changeSupport.firePropertyChange("dishId", oldDishId, dishId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ecafe.Orders[ orderId=" + orderId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
