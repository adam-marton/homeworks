package xyz.codingmentor.entity;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import xyz.codingmentor.constraint.ColorOfAppleDevice;
import xyz.codingmentor.constraint.ColorOfSamsungDevice;
import xyz.codingmentor.annotation.Validate;

/**
 *
 * @author Ádám
 */
@Validate
@ColorOfAppleDevice
@ColorOfSamsungDevice
public class DeviceEntity {
    @NotNull
    @Size(min = 36, max = 36)
    private String id;
    @NotNull
    private Manufacturer manufacturer;
    @NotNull
    @Size(min = 3)
    private String type;
    @NotNull
    @Min(1)
    private Integer price;
    @NotNull
    private Color color;
    @NotNull
    @Min(0)
    private Integer count;

    public DeviceEntity() {
        //default constructor for Json
    }

    private DeviceEntity(Builder builder) {
        this.id = builder.id;
        this.manufacturer = builder.manufacturer;
        this.type = builder.type;
        this.price = builder.price;
        this.color = builder.color;
        this.count = builder.count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    public static class Builder {
        private String id;
        private Manufacturer manufacturer;
        private String type;
        private Integer price;
        private Color color;
        private Integer count;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        
        public Builder manufacturer(Manufacturer manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }
        
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        
        public Builder price(Integer price) {
            this.price = price;
            return this;
        }
        
        public Builder color(Color color) {
            this.color = color;
            return this;
        }
        
        public Builder count(Integer count) {
            this.count = count;
            return this;
        }
        
        public DeviceEntity build() {
            return new DeviceEntity(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.manufacturer);
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + Objects.hashCode(this.price);
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + Objects.hashCode(this.count);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DeviceEntity other = (DeviceEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (this.manufacturer != other.manufacturer) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.count, other.count)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nDeviceEntity: " + "id=" + id + ", manufacturer=" + manufacturer + ", type=" + type + 
                ", price=" + price + ", color=" + color + ", count=" + count;
    }
}
