package com.group3.backend.service.helper;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.group3.backend.ui.model.request.ResidentRequest;

public class Utility {
	/**
	    * Creates a String array of the properties' names that are either null or 0
	    * 
	    * credit to:
	    * https://stackoverflow.com/a/19739041/13242162
	    * 
	    * @param source(ResidentRequest)
	    * @return String[] of null or equal to 0 property names
	    */
	    public static String[] getNullPropertyNames(ResidentRequest residentRequest) {
	        final BeanWrapper resReq = new BeanWrapperImpl(residentRequest);
	        PropertyDescriptor[] pds = resReq.getPropertyDescriptors();
	        
	        Set<String> emptyNames = new HashSet<String>();
	        for (PropertyDescriptor pd : pds) {
	            Object srcValue = resReq.getPropertyValue(pd.getName());
	            if (srcValue == null || srcValue.equals(0) )
	                emptyNames.add(pd.getName());
	        }
	        String[] result = new String[emptyNames.size()];
	        return emptyNames.toArray(result);
	    }
}
