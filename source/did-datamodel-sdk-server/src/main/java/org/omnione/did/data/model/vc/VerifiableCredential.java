/*
 * Copyright 2024 OmniOne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omnione.did.data.model.vc;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import org.omnione.did.data.model.DataObject;
import org.omnione.did.data.model.did.constants.DateFormatConstants;
import org.omnione.did.data.model.enums.vc.Encoding;
import org.omnione.did.data.model.util.json.GsonWrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 
 * The format complies with W3C's [VC-MODEL].
 */

@Getter
@Setter
public class VerifiableCredential extends DataObject{

  public static final String CONTEXT = "https://www.w3.org/ns/credentials/v2";
  public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZZZZ");

  /**
   * JSON-LD context ["https://www.w3.org/ns/credentials/v2"]
   */

  @SerializedName("@context")
  @Expose @NotEmpty
  private List<String> context;


  /**
   * VC id - UUID
   */
  @SerializedName("id")
  @Expose @NotEmpty
  private String id;

  /**
   *  VCType enum value
   */
  @SerializedName("type")
  @Expose 
  @NotEmpty
  private List<String> type;


  /**
   * Issuer Infos
   */
  @SerializedName("issuer")
  @Expose 
  @Valid @NotNull
  private Issuer issuer;

  /**
   * Issued time(UTC)
   */
  @SerializedName("issuanceDate")
  @Expose @NotEmpty
  @Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
  private String issuanceDate;

  /**
   * Validity period start time(UTC)
   */
  @SerializedName("validFrom")
  @Expose @NotEmpty
  @Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
  private String validFrom;

  /**
   * VC File encoding 
   * enum Encoding value
   * default UTF-8
   */
  @SerializedName("encoding")
  @Expose @NotEmpty
  private String encoding = Encoding.UTF_8.getRawValue();


  /**
   * Validity period end time(UTC)
   */
  @SerializedName("validUntil")
  @Expose @NotEmpty
  @Pattern(regexp = DateFormatConstants.DATA_FORMAT, message = DateFormatConstants.DATA_FORMAT_MESSAGE)
  private String validUntil;

  /**
   * VC format version
   * default 1.0
   */
  @SerializedName("formatVersion")
  @Expose @NotEmpty
  private String formatVersion = "1.0";

  /**
   * VC File language
   */
  @SerializedName("language")
  @Expose @NotEmpty
  private String language;


  /**
   * How to verify your identity or qualifications
   */
  @SerializedName("evidence")
  @Expose
  private List<? extends Evidence> evidence;


  /**
   * credential Schema
   */
  @SerializedName("credentialSchema")
  @Expose @NotNull
  @Valid
  private CredentialSchema credentialSchema;

  /**
   * credential subject
   */
  @SerializedName("credentialSubject")
  @Expose @NotNull
  @Valid
  private CredentialSubject credentialSubject;

  /**
   * Issuer signatures for VC
   */
  @SerializedName("proof")
  @Expose
  @Valid
  private VcProof proof;


  @Override
  public void fromJson(String val) {
    GsonWrapper gson = new GsonWrapper();
    VerifiableCredential data = gson.fromJson(val, VerifiableCredential.class);

    context = data.context;
    id = data.id;
    issuer = data.issuer;
    issuanceDate = data.issuanceDate;
    validFrom = data.validFrom;
    encoding = data.encoding;
    validUntil = data.validUntil;
    formatVersion = data.formatVersion;
    language = data.language;
    credentialSchema = data.credentialSchema;
    credentialSubject = data.credentialSubject;
    proof = data.proof;
    evidence = data.evidence;
    type = data.type;
  }

  public void setContext(List<String> context) {
	  ArrayList<String> contextList = new ArrayList<String>(context);
	  contextList.add(0, CONTEXT);
	  this.context = contextList;
  }
  
  public void setContext() {
	  ArrayList<String> contextList = new ArrayList<String>();
	  contextList.add(CONTEXT);
	  this.context = contextList;
  }

  public void setId() {
    if ((null == this.id) || (this.id.length() <= 0)) {
      this.id = UUID.randomUUID().toString();
    }
  }

  public void setIssuanceDate(String issuanceDate) {
    this.issuanceDate = issuanceDate;
  }

  public void setIssuanceDate(ZonedDateTime issuanceDate) {
    this.issuanceDate = dateToString(issuanceDate);
  } 

  public ZonedDateTime getIssuanceDateObject() {
    return stringToDate(this.issuanceDate);
  }
  public void setValidFrom(String validFrom) {
    this.validFrom = validFrom;
  }

  public void setValidFrom(ZonedDateTime validFromObj) {
    this.validFrom = dateToString(validFromObj);
  }

  public ZonedDateTime getValidFromObject() {
    return stringToDate(this.validFrom);
  }

  public void setValidUntil(String validUntil) {
    this.validUntil = validUntil;
  }

  public void setValidUntil(ZonedDateTime validUntilObj) {
    this.validUntil = dateToString(validUntilObj);
  }

  public ZonedDateTime getValidUntilObject(){
    return stringToDate(this.validUntil);
  }

  public static String dateToString(ZonedDateTime date) {
    return date.format(DATE_FORMAT);
  }

  public static String dateToUTC0String(ZonedDateTime date) {
    return date.withZoneSameInstant(ZoneOffset.UTC).format(DATE_FORMAT);
  }

  public static ZonedDateTime stringToDate(String date) {
    ZonedDateTime zonedDateTime = null;
    try {
      zonedDateTime = ZonedDateTime.parse(date, DATE_FORMAT);

    } catch (DateTimeParseException e) {
      e.printStackTrace();
    }

    return zonedDateTime;
  }

  public static ZonedDateTime stringToUTC0Date(String date){
    ZonedDateTime utcZonedDateTime = null;
    try {
      utcZonedDateTime = ZonedDateTime.parse(date).withZoneSameInstant(ZoneOffset.UTC);
    } catch (DateTimeParseException e) {
      e.printStackTrace();
    }

    return utcZonedDateTime;
  }
}