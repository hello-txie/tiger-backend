package org.tiger.variables;

public enum Status {
  SUBMITTED("Submitted by the Scoping Architect"),
  SRB_APPROVED("Approved by the Scoping Review Board"),
  SRB_REJECTED("Rejected by the Scoping Review Board"),
  MA_APPROVED("Approved by the Managing Architect"),
  MA_REJECTED("Rejected by the Managing Architect");

  private final String description;

  Status(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
