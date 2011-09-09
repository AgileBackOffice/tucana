/**
 * 
 */
package org.agilebackoffice.wafe.ui.gwt.client.domain;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @author kamann
 *
 */
public class Constellation implements IsSerializable{
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

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getCode()
	 */
	public String getCode() {
		return code;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setCode(java.lang.String)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getGermanName()
	 */
	public String getGermanName() {
		return germanName;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setGermanName(java.lang.String)
	 */
	public void setGermanName(String germanName) {
		this.germanName = germanName;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getGenitiveName()
	 */
	public String getGenitiveName() {
		return genitiveName;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setGenitiveName(java.lang.String)
	 */
	public void setGenitiveName(String genitiveName) {
		this.genitiveName = genitiveName;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getHemisphere()
	 */
	public String getHemisphere() {
		return hemisphere;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setHemisphere(java.lang.String)
	 */
	public void setHemisphere(String hemisphere) {
		this.hemisphere = hemisphere;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getAuthor()
	 */
	public String getAuthor() {
		return author;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setAuthor(java.lang.String)
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getAuthorYear()
	 */
	public int getAuthorYear() {
		return authorYear;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setAuthorYear(int)
	 */
	public void setAuthorYear(int authorYear) {
		this.authorYear = authorYear;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getArea()
	 */
	public double getArea() {
		return area;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setArea(double)
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getVisibilityArea()
	 */
	public String getVisibilityArea() {
		return visibilityArea;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setVisibilityArea(java.lang.String)
	 */
	public void setVisibilityArea(String visibilityArea) {
		this.visibilityArea = visibilityArea;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getNumberOfStarsGreater3M()
	 */
	public int getNumberOfStarsGreater3M() {
		return numberOfStarsGreater3M;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setNumberOfStarsGreater3M(int)
	 */
	public void setNumberOfStarsGreater3M(int numberOfStarsGreater3M) {
		this.numberOfStarsGreater3M = numberOfStarsGreater3M;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getNumberOfStarsGreater4M()
	 */
	public int getNumberOfStarsGreater4M() {
		return numberOfStarsGreater4M;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setNumberOfStarsGreater4M(int)
	 */
	public void setNumberOfStarsGreater4M(int numberOfStarsGreater4M) {
		this.numberOfStarsGreater4M = numberOfStarsGreater4M;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getStarCardRef()
	 */
	public String getStarCardRef() {
		return starCardRef;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getGreatestMagnitude()
	 */
	public double getGreatestMagnitude() {
		return greatestMagnitude;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setGreatestMagnitude(double)
	 */
	public void setGreatestMagnitude(double greatestMagnitude) {
		this.greatestMagnitude = greatestMagnitude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#toString()
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

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setStarCardRef(java.lang.String)
	 */
	public void setStarCardRef(String starCardRef) {
		this.starCardRef = starCardRef;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#getId()
	 */
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see org.agilebackoffice.wafe.domain.IConstellation#setId(java.lang.Long)
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
