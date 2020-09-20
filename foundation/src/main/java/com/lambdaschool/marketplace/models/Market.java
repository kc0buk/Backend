package com.lambdaschool.marketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * The entity allowing interaction with the markets table
 */
@Entity
@Table(name = "markets")
public class Market extends Auditable {
  /**
   * The primary key (long) of the markets table.
   */
  @Id
  @GeneratedValue
  private long marketId;

  /**
   * Market name. Cannot be null.
   */
  @Column(nullable = false)
  private String name;

  @OneToMany(
    mappedBy = "market",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  @JsonIgnoreProperties(value = "item", allowSetters = true)
  private Set<Item> items = new HashSet<>();

  /**
   * Default constructor used primarily by the JPA.
   */
  public Market() {}

  /**
   * Give the params, create a new market object.
   * marketId is autogenerated
   *
   * @param name The name (String) of the market
   */
  public Market(String name) {
    this.name = name;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }

  /**
   * Getter for marketId
   *
   * @return the marketId (long) of the market
   */
  public long getMarketId() {
    return marketId;
  }

  /**
   * Setter for marketId. Used primary for seeding data
   *
   * @param marketId the new marketId (long) of the market
   */
  public void setMarketId(long marketId) {
    this.marketId = marketId;
  }

  /**
   * Getter for name
   *
   * @return the name (String) of the market
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for item name
   *
   * @param name (string) of the market
   */
  public void setName(String name) {
    this.name = name;
  }
}
