package com.challenge.backend.domain.repository;

import com.challenge.backend.domain.entity.LocationEntity;

public interface LocationRepository {

    LocationEntity getLocationInfo(String url) throws Exception;
}
