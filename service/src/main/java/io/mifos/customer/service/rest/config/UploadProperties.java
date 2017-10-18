/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.customer.service.rest.config;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author Myrle Krantz
 */
@Component
@ConfigurationProperties(prefix="upload")
@Validated
public class UploadProperties {
  @Valid
  private final Image image = new Image();

  public static class Image {
    @Range(min = 0L)
    private long maxSize;

    public long getMaxSize() {
      return maxSize;
    }

    public void setMaxSize(long maxSize) {
      this.maxSize = maxSize;
    }
  }

  public Image getImage() {
    return image;
  }
}
