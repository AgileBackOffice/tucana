/**
 * 
 */
package org.agilebackoffice.wafe.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * @author kamann
 *
 */
@Entity
@Indexed
public class Constellation implements Serializable{
	private static final long serialVersionUID = 5723129346307261594L;

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Field(index = Index.TOKENIZED, store = Store.YES)
	private String name;
	@Field(index = Index.TOKENIZED, store = Store.YES)
	private String code;
	@Field(index = Index.TOKENIZED, store = Store.YES)
	private String genitiveName;
	private String hemisphere;
	@Field(index = Index.TOKENIZED, store = Store.YES)
	private String author;
	private int authorYear;
	private double area;
	private double greatestMagnitude;
	private String visibilityArea;
	private int numberOfStarsGreater3M;
	private int numberOfStarsGreater4M;
	@Lob
	private byte[] starCardData;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ConstellationName> names = new ArrayList<ConstellationName>();

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Constellation [id=" + id + ", name=" + name + ", code=" + code
				+ ", genitiveName=" + genitiveName + ", hemisphere="
				+ hemisphere + ", author=" + author + ", authorYear="
				+ authorYear + ", area=" + area + ", greatestMagnitude="
				+ greatestMagnitude + ", visibilityArea=" + visibilityArea
				+ ", numberOfStarsGreater3M=" + numberOfStarsGreater3M
				+ ", numberOfStarsGreater4M=" + numberOfStarsGreater4M
				+ ", names=" + names + "]";
	}

	/**
	 * @return the starCardData
	 */
	public byte[] getStarCardData() {
		return starCardData;
	}

	/**
	 * @param starCardData the starCardData to set
	 */
	public void setStarCardData(byte[] starCardData) {
		this.starCardData = starCardData;
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

	/**
	 * @return the names
	 */
	public List<ConstellationName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<ConstellationName> names) {
		this.names = names;
	}
}
