/*
 * Copyright (c) 2002-2016 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with
 * separate copyright notices and license terms. Your use of the source
 * code for these subcomponents is subject to the terms and
 *  conditions of the subcomponent's license, as noted in the LICENSE file.
 */

package org.neo4j.ogm.cypher;

/**
 * A parameter along with filter information to be added to a query.
 *
 * @author Luanne Misquitta
 */
public class Filter {

	/**
	 * The property name on the entity to be used in the filter
	 */
	private String propertyName;

	/**
	 * The value of the property to filter on
	 */
	private Object propertyValue;

	/**
	 * @deprecated as of 2.0.4 This is a SDN only concern and has been moved to that project.
	 * The position of the property as specified in a derived finder method
	 */
	@Deprecated
	private Integer propertyPosition;

	/**
	 * The comparison operator to use in the property filter
	 */
	private ComparisonOperator comparisonOperator = ComparisonOperator.EQUALS;

	/**
	 * The boolean operator used to append this filter to the previous ones.
	 * Mandatory if the filter is not the first and only filter in the list.
	 */
	private BooleanOperator booleanOperator = BooleanOperator.NONE;

	/**
	 * Determines whether or not this filter condition should be negated when added to the query.
	 */
	private boolean negated;

	/**
	 * The parent entity which owns this filter
	 */
	private Class<?> ownerEntityType;

	/**
	 * The label of the entity which contains the nested property
	 */
	private String nestedEntityTypeLabel;

	/**
	 * The property name of the nested property on the parent entity
	 */
	private String nestedPropertyName;

	/**
	 * The type of the entity that owns the nested property
	 */
	private Class<?> nestedPropertyType;

	/**
	 * The relationship type to be used for a nested property
	 */
	private String relationshipType;

	/**
	 * The relationship direction from the parent entity to the nested property
	 */
	private String relationshipDirection;

	/**
	 * Whether the nested property is backed by a relationship entity
	 */
	private boolean nestedRelationshipEntity;

	public Filter() {
	}

	public Filter(String propertyName, Object propertyValue) {
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	public String getRelationshipDirection() {
		return relationshipDirection;
	}

	public void setRelationshipDirection(String relationshipDirection) {
		this.relationshipDirection = relationshipDirection;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}

	/**
	 * @deprecated as of 2.0.4. This is a SDN only concern and has been moved to that project.
	 */
	@Deprecated
	public Integer getPropertyPosition() {
		return propertyPosition;
	}

	/**
	 * @deprecated as of 2.0.4. This is a SDN only concern and has been moved to that project.
	 */
	@Deprecated
	public void setPropertyPosition(Integer propertyPosition) {
		this.propertyPosition = propertyPosition;
	}

	public ComparisonOperator getComparisonOperator() {
		return comparisonOperator;
	}

	public void setComparisonOperator(ComparisonOperator comparisonOperator) {
		this.comparisonOperator = comparisonOperator;
	}

	public BooleanOperator getBooleanOperator() {
		return booleanOperator;
	}

	public void setBooleanOperator(BooleanOperator booleanOperator) {
		this.booleanOperator = booleanOperator;
	}

	/**
	 * @return <code>true</code> if this filter expression is to be negated when it's appended to the query, <code>false</code>
	 * if not
	 */
	public boolean isNegated() {
		return negated;
	}

	/**
	 * @param negated Whether or not the filter expression is to be negated
	 */
	public void setNegated(boolean negated) {
		this.negated = negated;
	}


	public Class<?> getOwnerEntityType() {
		return ownerEntityType;
	}

	public void setOwnerEntityType(Class<?> ownerEntityType) {
		this.ownerEntityType = ownerEntityType;
	}

	public String getNestedPropertyName() {
		return nestedPropertyName;
	}

	public void setNestedPropertyName(String nestedPropertyName) {
		this.nestedPropertyName = nestedPropertyName;
	}

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public boolean isNested() {
		return this.nestedPropertyName != null;
	}

	public Class<?> getNestedPropertyType() {
		return nestedPropertyType;
	}

	public void setNestedPropertyType(Class<?> nestedPropertyType) {
		this.nestedPropertyType = nestedPropertyType;
	}

	public String getNestedEntityTypeLabel() {
		return nestedEntityTypeLabel;
	}

	public void setNestedEntityTypeLabel(String nestedEntityTypeLabel) {
		this.nestedEntityTypeLabel = nestedEntityTypeLabel;
	}

	public boolean isNestedRelationshipEntity() {
		return nestedRelationshipEntity;
	}

	public void setNestedRelationshipEntity(boolean nestedRelationshipEntity) {
		this.nestedRelationshipEntity = nestedRelationshipEntity;
	}

    /**
     * Returns the result of passing the property value through the transformer associated with the comparison operator
     * on this {@link Filter}.
     *
     * @return The transformed property value
     */
    public Object getTransformedPropertyValue() {
       return this.comparisonOperator.getPropertyValueTransformer().transformPropertyValue(this.propertyValue);
    }

}
