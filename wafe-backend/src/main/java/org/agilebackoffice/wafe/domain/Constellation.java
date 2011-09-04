/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author kamann
 *
 */
@Entity
public class Constellation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String code;
	private String germanName;
	private String genitiveName;
	private String hemisphere;
	private String author;
	private int authorYear;
	private double area;
	private double greatestMagnitude;
	private String visibilityArea;
	private int numberOfStarsGreater3M;
	private int numberOfStarsGreater4M;
	private String starCardRef;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the germanName
	 */
	public String getGermanName() {
		return germanName;
	}

	/**
	 * @param germanName
	 *            the germanName to set
	 */
	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}

	/**
	 * @return the genitiveName
	 */
	public String getGenitiveName() {
		return genitiveName;
	}

	/**
	 * @param genitiveName
	 *            the genitiveName to set
	 */
	public void setGenitiveName(String genitiveName) {
		this.genitiveName = genitiveName;
	}

	/**
	 * @return the hemisphere
	 */
	public String getHemisphere() {
		return hemisphere;
	}

	/**
	 * @param hemisphere
	 *            the hemisphere to set
	 */
	public void setHemisphere(String hemisphere) {
		this.hemisphere = hemisphere;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the authorYear
	 */
	public int getAuthorYear() {
		return authorYear;
	}

	/**
	 * @param authorYear
	 *            the authorYear to set
	 */
	public void setAuthorYear(int authorYear) {
		this.authorYear = authorYear;
	}

	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return the visibility
	 */
	public String getVisibilityArea() {
		return visibilityArea;
	}

	/**
	 * @param visibility
	 *            the visibility to set
	 */
	public void setVisibilityArea(String visibilityArea) {
		this.visibilityArea = visibilityArea;
	}

	/**
	 * @return the numberOfStarsGreater3M
	 */
	public int getNumberOfStarsGreater3M() {
		return numberOfStarsGreater3M;
	}

	/**
	 * @param numberOfStarsGreater3M
	 *            the numberOfStarsGreater3M to set
	 */
	public void setNumberOfStarsGreater3M(int numberOfStarsGreater3M) {
		this.numberOfStarsGreater3M = numberOfStarsGreater3M;
	}

	/**
	 * @return the numberOfStarsGreater4M
	 */
	public int getNumberOfStarsGreater4M() {
		return numberOfStarsGreater4M;
	}

	/**
	 * @param numberOfStarsGreater4M
	 *            the numberOfStarsGreater4M to set
	 */
	public void setNumberOfStarsGreater4M(int numberOfStarsGreater4M) {
		this.numberOfStarsGreater4M = numberOfStarsGreater4M;
	}

	/**
	 * @return the starCardRef
	 */
	public String getStarCardRef() {
		return starCardRef;
	}

	/**
	 * @return the greatestMagnitude
	 */
	public double getGreatestMagnitude() {
		return greatestMagnitude;
	}

	/**
	 * @param greatestMagnitude
	 *            the greatestMagnitude to set
	 */
	public void setGreatestMagnitude(double greatestMagnitude) {
		this.greatestMagnitude = greatestMagnitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Constellation ["
				+ (name != null ? "name=" + name + ", " : "")
				+ (code != null ? "code=" + code + ", " : "")
				+ (germanName != null ? "germanName=" + germanName + ", " : "")
				+ (genitiveName != null ? "genitiveName=" + genitiveName + ", "
						: "")
				+ (hemisphere != null ? "hemisphere=" + hemisphere + ", " : "")
				+ (author != null ? "author=" + author + ", " : "")
				+ "authorYear="
				+ authorYear
				+ ", area="
				+ area
				+ ", greatestMagnitude="
				+ greatestMagnitude
				+ ", "
				+ (visibilityArea != null ? "visibilityArea=" + visibilityArea
						+ ", " : "") + "numberOfStarsGreater3M="
				+ numberOfStarsGreater3M + ", numberOfStarsGreater4M="
				+ numberOfStarsGreater4M + ", "
				+ (starCardRef != null ? "starCardRef=" + starCardRef : "")
				+ "]";
	}

	/**
	 * @param starCardRef
	 *            the starCardRef to set
	 */
	public void setStarCardRef(String starCardRef) {
		this.starCardRef = starCardRef;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
