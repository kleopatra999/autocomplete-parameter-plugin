package org.jenkinsci.plugins.autocompleteparameter;

import com.cloudbees.plugins.credentials.CredentialsMatchers;
import com.cloudbees.plugins.credentials.CredentialsProvider;
import com.cloudbees.plugins.credentials.common.StandardUsernamePasswordCredentials;
import com.cloudbees.plugins.credentials.domains.URIRequirementBuilder;

import hudson.model.Item;
import hudson.security.ACL;

public class CredentialsUtils {
	public static StandardUsernamePasswordCredentials lookupUsernamePasswordCredentials(String uri, String credentialsId) {
		if (credentialsId == null) 
			return null;
		return CredentialsMatchers.firstOrNull(
				CredentialsProvider.lookupCredentials(
						StandardUsernamePasswordCredentials.class,
						(Item)null,
						ACL.SYSTEM,
						URIRequirementBuilder.fromUri(uri).build()),
					CredentialsMatchers.withId(credentialsId)
				);
	}
	
	public static StandardUsernamePasswordCredentials lookupUsernamePasswordCredentials(String credentialsId) {
		return lookupUsernamePasswordCredentials("", credentialsId);
	}
}