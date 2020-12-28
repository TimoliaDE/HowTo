package de.timolia.howto.conversion.models;

import de.timolia.howto.conversion.SQLApi;

import java.util.UUID;

public class TeamlerResponsibilities {

    private final String name;
    private final UUID uuid;
    private final String hv;
    private final String nv;

    public TeamlerResponsibilities(String name, String hv, String nv) {
        this.name = name;
        this.uuid = SQLApi.getUuid(name);
        this.hv = hv;
        this.nv = nv;
    }


    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getHv() {
        return hv;
    }

    public String getNv() {
        return nv;
    }


    @Override
    public String toString() {
        return "TeamlerResponsibilities{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", hv='" + hv + '\'' +
                ", nv='" + nv + '\'' +
                '}';
    }

}
