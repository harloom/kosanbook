/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enity;

import java.util.Objects;

/**
 *
 * @author Hx-loom
 */
public class Harga {
    private Integer id;
    private Integer h50mbps;
    private Integer h30mbps;
    private Integer h20mbps;
    private Integer hvip;
    private Integer hstandard;
    private Integer hkosong;
    private String tanggal_update;

    public Harga(Integer id, Integer h50mbps, Integer h30mbps, Integer h20mbps, Integer hvip, Integer hstandard, Integer hkosong, String tanggal_update) {
        this.id = id;
        this.h50mbps = h50mbps;
        this.h30mbps = h30mbps;
        this.h20mbps = h20mbps;
        this.hvip = hvip;
        this.hstandard = hstandard;
        this.hkosong = hkosong;
        this.tanggal_update = tanggal_update;
    }

    public Harga() {
        
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getH50mbps() {
        return h50mbps;
    }

    public void setH50mbps(Integer h50mbps) {
        this.h50mbps = h50mbps;
    }

    public Integer getH30mbps() {
        return h30mbps;
    }

    public void setH30mbps(Integer h30mbps) {
        this.h30mbps = h30mbps;
    }

    public Integer getH20mbps() {
        return h20mbps;
    }

    public void setH20mbps(Integer h20mbps) {
        this.h20mbps = h20mbps;
    }

    public Integer getHvip() {
        return hvip;
    }

    public void setHvip(Integer hvip) {
        this.hvip = hvip;
    }

    public Integer getHstandard() {
        return hstandard;
    }

    public void setHstandard(Integer hstandard) {
        this.hstandard = hstandard;
    }

    public Integer getHkosong() {
        return hkosong;
    }

    public void setHkosong(Integer hkosong) {
        this.hkosong = hkosong;
    }

    public String getTanggal_update() {
        return tanggal_update;
    }

    public void setTanggal_update(String tanggal_update) {
        this.tanggal_update = tanggal_update;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.h50mbps);
        hash = 41 * hash + Objects.hashCode(this.h30mbps);
        hash = 41 * hash + Objects.hashCode(this.h20mbps);
        hash = 41 * hash + Objects.hashCode(this.hvip);
        hash = 41 * hash + Objects.hashCode(this.hstandard);
        hash = 41 * hash + Objects.hashCode(this.hkosong);
        hash = 41 * hash + Objects.hashCode(this.tanggal_update);
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
        final Harga other = (Harga) obj;
        if (!Objects.equals(this.tanggal_update, other.tanggal_update)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.h50mbps, other.h50mbps)) {
            return false;
        }
        if (!Objects.equals(this.h30mbps, other.h30mbps)) {
            return false;
        }
        if (!Objects.equals(this.h20mbps, other.h20mbps)) {
            return false;
        }
        if (!Objects.equals(this.hvip, other.hvip)) {
            return false;
        }
        if (!Objects.equals(this.hstandard, other.hstandard)) {
            return false;
        }
        if (!Objects.equals(this.hkosong, other.hkosong)) {
            return false;
        }
        return true;
    }


    
    
    
}
