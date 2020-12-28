package de.timolia.howto;

import de.timolia.howto.models.Teamler;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Utils {

    public static List<Teamler> getTeamler(List<Teamler> teamlers, UUID... uuid) {
        List<UUID> uuids = Arrays.asList(uuid);
        return teamlers.stream().filter(teamler -> uuids.contains(teamler.getUuid())).collect(Collectors.toList());
    }

    public static class KeyValuePair<T, U> {

        private final T key;
        private final U value;

        public KeyValuePair(T key, U value) {
            this.key = key;
            this.value = value;
        }


        public T getKey() {
            return key;
        }

        public U getValue() {
            return value;
        }

    }

}
