<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.commsen.liferay.multidevice.rules.actions.NoAction"%>
<%@page import="com.commsen.liferay.multidevice.rules.actions.RedirectAction"%>
<%@page import="com.commsen.liferay.multidevice.rules.actions.ChangeThemeAction"%>
<%@page import="com.commsen.liferay.multidevice.rules.actions.DeviceAction"%>
<%@page import="org.apache.commons.lang.StringUtils"%>

<%@page import="com.commsen.liferay.multidevice.rules.DeviceRulesUtil"%>
<%@page import="com.commsen.liferay.multidevice.rules.RuleInfo"%>
<%@page import="com.commsen.liferay.multidevice.rules.ThemeAndColorScheme"%>
<%@page import="com.commsen.liferay.multidevice.VersionableName"%>
<%@page import="com.commsen.liferay.multidevice.DevicesUtil"%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.model.ColorScheme"%>
<%@page import="com.liferay.portal.model.Theme"%>
<%@page import="com.liferay.portal.service.ThemeLocalServiceUtil"%>
<%@page import="java.util.List"%>


<liferay-ui:error key="failed-to-create-rule" message="failed-to-create-rule" />
<liferay-ui:error key="failed-to-save-rule" message="failed-to-save-rule" />
<liferay-ui:error key="failed-to-delete-rule" message="failed-to-delete-rule" />
<liferay-ui:error key="rule-is-empty" message="rule-is-empty" />

<div class="float-container">

	<h3>
		<span class="header-title"><liferay-ui:message key="rules.add-rule" /></span> 
	</h3>
	<table class="lfr-table">
		<tbody>
			<tr>
				<td><label for="<portlet:namespace />rulePriority"><liferay-ui:message key="rules.priority" /></label></td>
				<td>
					<input id="<portlet:namespace />rulePriority" name="<portlet:namespace />rulePriority" size="4" value="100"/>
				</td>
				<td colspan="2">
					<input id="<portlet:namespace />saveRule" name="<portlet:namespace />saveRule" type="button" value="Save"/>
				</td>
			</tr>
			<tr>
				<th colspan="4"><liferay-ui:message key="rules.if-device-matches-the-following-criteria" /></th>
			</tr>
			<tr>
				<td><label for="<portlet:namespace />brand"><liferay-ui:message key="rules.brand-is" /></label></td>
				<td>
					<select id="<portlet:namespace />brand" name="<portlet:namespace />brand" >
						<option value=""><liferay-ui:message key="rules.any" /></option>
						<%
						for (VersionableName brand : DevicesUtil.getBrands()) {
						%>
						<option><%= HtmlUtil.escape(brand.getName()) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td><label for="<portlet:namespace />model"><liferay-ui:message key="rules.model" /></label></td>
				<td>
					<select id="<portlet:namespace />model" name="<portlet:namespace />model">
						<option value=""><liferay-ui:message key="rules.any" /></option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="<portlet:namespace />os"><liferay-ui:message key="rules.operating-system-is" /></label></td>
				<td>
					<select id="<portlet:namespace />os" name="<portlet:namespace />os" >
						<option value=""><liferay-ui:message key="rules.any" /></option>
						<%
						for (VersionableName os : DevicesUtil.getOperatingSystems()) {
						%>
						<option><%= HtmlUtil.escape(os.getName()) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td><label for="<portlet:namespace />osVersion"><liferay-ui:message key="rules.version" /></label></td>
				<td>
					<select id="<portlet:namespace />osVersion" name="<portlet:namespace />osVersion">
						<option value=""><liferay-ui:message key="rules.any" /></option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="<portlet:namespace />"><liferay-ui:message key="rules.browser-is" /></label></td>
				<td>
					<select id="<portlet:namespace />browser" name="<portlet:namespace />browser" >
						<option value=""><liferay-ui:message key="rules.any" /></option>
						<%
						for (VersionableName browser : DevicesUtil.getBrowsers()) {
						%>
						<option><%= HtmlUtil.escape(browser.getName()) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td><label for="<portlet:namespace />browserVersion"><liferay-ui:message key="rules.version" /></label></td>
				<td>
					<select id="<portlet:namespace />browserVersion" name="<portlet:namespace />browserVersion">
						<option value=""><liferay-ui:message key="rules.any" /></option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="<portlet:namespace />pointingMethod"><liferay-ui:message key="rules.pointing-method-is" /></label></td>
				<td>
					<select id="<portlet:namespace />pointingMethod" name="<portlet:namespace />pointingMethod" >
						<option value=""><liferay-ui:message key="rules.any" /></option>
						<%
						for (String pointingMethod : DevicesUtil.getPointingMethods()) {
						%>
						<option><%= HtmlUtil.escape(pointingMethod) %></option>
						<%
						}
						%>
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><label for="<portlet:namespace />isTablet"><liferay-ui:message key="rules.device-is-tablet" /></label></td>
				<td>
					<select id="<portlet:namespace />isTablet" name="<portlet:namespace />isTablet" >
						<option value=""><liferay-ui:message key="rules.doesn-t-matter" /></option>
						<option value="yes"><liferay-ui:message key="yes" /></option>
						<option value="no"><liferay-ui:message key="no" /></option>
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><label for="<portlet:namespace />hasQwertyKeyboard"><liferay-ui:message key="rules.device-has-qwerty-keyboard" /></label></td>
				<td>
					<select id="<portlet:namespace />hasQwertyKeyboard" name="<portlet:namespace />hasQwertyKeyboard" >
						<option value=""><liferay-ui:message key="rules.doesn-t-matter" /></option>
						<option value="yes"><liferay-ui:message key="yes" /></option>
						<option value="no"><liferay-ui:message key="no" /></option>
					</select>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="4">
					<strong><liferay-ui:message key="rules.then" /></strong>
				</td>
			</tr>
			<tr>
				<td><input type="radio" name="<portlet:namespace />ruleAction" id="<portlet:namespace />ruleAction_changeTheme" value="<%=ChangeThemeAction.NAME %>"/> <label for="<portlet:namespace />ruleAction_changeTheme"><liferay-ui:message key="rules.apply-theme" /></label></td>
				<td>
					<div style="position:relative;">
						<input id="<portlet:namespace />dynamicThemeId" name="<portlet:namespace />dynamicThemeId" type="hidden"/>
						<input id="<portlet:namespace />dynamicColorSchemeId" name="<portlet:namespace />dynamicColorSchemeId" type="hidden"/>
						<label for="<portlet:namespace />ruleAction_changeTheme">
							<a class="theme-entry" href="#" id="<portlet:namespace />selectedTheme">
								<span class="theme-title" id="<portlet:namespace />selectedThemeName"><liferay-ui:message key="rules.no-theme-selected" /></span>
								<img class="theme-thumbnail" id="<portlet:namespace />selectedThemeImg" class="theme-thumbnail" src="/html/themes/classic/images/spacer.png" />
							</a>
						</label>
					</div>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="radio" name="<portlet:namespace />ruleAction" id="<portlet:namespace />ruleAction_redirect" value="<%=RedirectAction.NAME %>"/> <label for="<portlet:namespace />ruleAction_redirect"><liferay-ui:message key="rules.redirect" /></label></td>
				<td>
					<div style="position:relative;">
						<label for="<portlet:namespace />ruleAction_redirect">
							<input id="<portlet:namespace />redirectRuleURL" name="<portlet:namespace />redirectRuleURL" type="text"/>
						</label>
					</div>
				</td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>

<%
List<RuleInfo> deviceRules = DeviceRulesUtil.getRules(company.getCompanyId(), liveGroupId, selPlid);
%>

<div class="float-container">

	<h3>
		<span class="header-title"><liferay-ui:message key="rules.rules" />  </span> 
	</h3>
	 
	<liferay-ui:search-container
		emptyResultsMessage="no-rules" 
		curParam="cur1"
		>
		
		<%-- 
			Define result list and count 
		--%>
		<liferay-ui:search-container-results 
			results="<%=deviceRules %>"
			total="<%=deviceRules.size() %>"
			/>
			
		<%-- 
			Configure table row  
		--%>
		<liferay-ui:search-container-row
			className="com.commsen.liferay.multidevice.rules.RuleInfo"
			keyProperty="id"
			modelVar="currentRule"
		>
	
			<%-- 
				First column contains priority 
			--%>
			<liferay-ui:search-container-column-text name="priority">
				<%=currentRule.getPriority() %>
			</liferay-ui:search-container-column-text>
	
			<%-- 
				Second column contains rule as text 
			--%>
			<liferay-ui:search-container-column-text name="rule">
				<%=currentRule.getText() %>
			</liferay-ui:search-container-column-text>
	
			<%-- 
				Third column contains action 
			--%>
			<liferay-ui:search-container-column-text name="action">
<%
				DeviceAction deviceAction = currentRule.getDeviceAction(); 
				if (deviceAction != null) {
					if (deviceAction instanceof ChangeThemeAction) {
						ChangeThemeAction changeThemeAction = (ChangeThemeAction)deviceAction;
						ThemeAndColorScheme themeAndColorScheme = changeThemeAction.getThemeAndColorScheme();
						Theme ruleTheme = ThemeLocalServiceUtil.getTheme(company.getCompanyId(), themeAndColorScheme.getThemeId(), false);
						ColorScheme ruleColorScheme = null;
						if (!StringUtils.isBlank(themeAndColorScheme.getColorSchemeId())) {
							ruleColorScheme = ThemeLocalServiceUtil.getColorScheme(company.getCompanyId(), ruleTheme.getThemeId(), themeAndColorScheme.getColorSchemeId(), false);
						}
						
						String name;
						String url; 
						if (ruleColorScheme == null) { 
							name = ruleTheme.getName();
							url = ruleTheme.getContextPath()+ ruleTheme.getImagesPath() + "/thumbnail.png";
						} else {
							name = ruleTheme.getName() + "(" + ruleColorScheme.getName() + ")";
							url = ruleTheme.getContextPath()+ ruleColorScheme.getColorSchemeThumbnailPath() + "/thumbnail.png";
						} 
%>
						<div style="position:relative;">
							<liferay-ui:message key="rules.apply-theme" />
							<a class="theme-entry">
								<span class="theme-title"><%= name %></span>
								<img alt="<%=name %>" class="theme-thumbnail" src="<%=url %>" title="<%=name %>" />
							</a>
						</div>
<%
					} else  if (deviceAction instanceof RedirectAction) {
						RedirectAction redirectAction = (RedirectAction)deviceAction;
						String url = redirectAction.getUrl();
%>
						<div style="position:relative;">
							<liferay-ui:message key="rules.redirect" /> <%=url %>
						</div>
<%
					} else  if (deviceAction instanceof NoAction) {
%>
						<div style="position:relative;">
							NO ACTION !!!
						</div>
<%
						
					} else {
%>
						<div style="position:relative;">
							unknown action
						</div>
<%
						
					}
				} else {
%>
					<div style="position:relative;">
						NO action !!!
					</div>
<%
				}
%>
			</liferay-ui:search-container-column-text>
	
			<%-- 
				Fourth column contains delete button 
			--%>
			<liferay-ui:search-container-column-text>
				<input type="button" onClick="javascript:<portlet:namespace />deleteRule(<%=currentRule.getId() %>)" value="<liferay-ui:message key="rules.delete-this-rule" />" />
			</liferay-ui:search-container-column-text>
	
		</liferay-ui:search-container-row>
	
		<%-- 
			Configuration done. Iterate over results and display    
		--%>
		<liferay-ui:search-iterator />
	
		<input id="<portlet:namespace />deleteRuleId" name="<portlet:namespace />deleteRuleId" type="hidden"/>
	
	</liferay-ui:search-container>

</div>

 
<aui:script use="liferay-auto-fields">


	AUI().ready('node', 'aui-dialog', 'aui-overlay-manager', 'dd-constrain', 'io-form' , function(A) {
		
		A.one('#<portlet:namespace />brand').on('change', function (e) {
			changeModel (e.target.get('value'));
		});

		A.one('#<portlet:namespace />os').on('change', function (e) {
			changeOSVersions (e.target.get('value'));
		});

		A.one('#<portlet:namespace />browser').on('change', function (e) {
			changeBrowserVersions (e.target.get('value'));
		});


		function changeModel (brand) {
			versionNode = A.one('#<portlet:namespace />model');
			versionNode.all('option').remove();
			versionNode.append('<option value="">ANY</option>');
			<%
			for (VersionableName brand : DevicesUtil.getBrands()) {
			%>
			if ('<%=brand.getName() %>' == brand) {
				<%
				for (String model : brand.getVersions()) {
				%>
					versionNode.append('<option><%= HtmlUtil.escape(model) %></option>');
				<%
				}
				%>
			}
			<%
			}
			%>
		}

		
		function changeOSVersions (osName) {
			versionNode = A.one('#<portlet:namespace />osVersion');
			versionNode.all('option').remove();
			versionNode.append('<option value="">ANY</option>');
			<%
			for (VersionableName os : DevicesUtil.getOperatingSystems()) {
			%>
			if ('<%=os.getName() %>' == osName) {
				<%
				for (String version : os.getVersions()) {
				%>
					versionNode.append('<option><%= HtmlUtil.escape(version) %></option>');
				<%
				}
				%>
			}
			<%
			}
			%>
		}

		function changeBrowserVersions (browserName) {
			versionNode = A.one('#<portlet:namespace />browserVersion');
			versionNode.all('option').remove();
			versionNode.append('<option value="">ANY</option>');
			<%
			for (VersionableName browser : DevicesUtil.getBrowsers()) {
			%>
			if ('<%=browser.getName() %>' == browserName) {
				<%
				for (String version : browser.getVersions()) {
				%>
					versionNode.append('<option><%= HtmlUtil.escape(version) %></option>');
				<%
				}
				%>
			}
			<%
			}
			%>
		}

		var themes = '<ul class="lfr-component lfr-theme-list" id="<portlet:namespace />themes">';
		<%
		List<Theme> themes = ThemeLocalServiceUtil.getThemes(company.getCompanyId(), liveGroupId, user.getUserId(), false);
		Iterator<Theme> itr = themes.iterator();
		while (itr.hasNext()) {
			Theme curTheme = itr.next();
			List<ColorScheme> colorSchemes = curTheme.getColorSchemes();

		%>
			themes += '	<li><a class="theme-entry" href="javascript:<portlet:namespace />selectLookAndFeel(\'<%= curTheme.getThemeId() %>\', \'\', \'<%= curTheme.getContextPath() %><%= curTheme.getImagesPath() %>/thumbnail.png\', \'<%= curTheme.getName() %>\');">';
			themes += '			<span class="theme-title"><%= curTheme.getName() %></span>';
			themes += '			<img alt="<%= curTheme.getName() %>" class="theme-thumbnail" src="<%= curTheme.getContextPath() %><%= curTheme.getImagesPath() %>/thumbnail.png" title="<%= curTheme.getName() %>" />';
		<%
			if (!colorSchemes.isEmpty()) {
		%>
			themes += '<ul class="lfr-component lfr-theme-list">';
		<%
				Iterator<ColorScheme> colorSchemeIterator = colorSchemes.iterator();
				while (colorSchemeIterator.hasNext()) {
					ColorScheme curColorScheme = colorSchemeIterator.next();
		%>
			themes += '	<li><a class="theme-entry" href="javascript:<portlet:namespace />selectLookAndFeel(\'<%= curTheme.getThemeId() %>\', \'<%= curColorScheme.getColorSchemeId() %>\', \'<%= curTheme.getContextPath() %><%= curColorScheme.getColorSchemeThumbnailPath() %>/thumbnail.png\', \'<%= curTheme.getName() %> (<%= curColorScheme.getName() %>)\');">';
			themes += '			<span class="theme-title"><%= curColorScheme.getName() %></span>';
			themes += '			<img alt="<%= curColorScheme.getName() %>" class="theme-thumbnail" src="<%= curTheme.getContextPath() %><%= curColorScheme.getColorSchemeThumbnailPath() %>/thumbnail.png" title="<%= curColorScheme.getName() %>" />';
			themes += '	</a></li>';
			
		<%
				}
		%>
			themes += '</ul>';
		<%
			}
		%>
			themes += '	</a></li>';
		<%
		}
		%>
		themes += '</ul>';



		A.one('#<portlet:namespace />selectedTheme').on('click', function (e) {
			var t = new A.Dialog({
				title: '<liferay-ui:message key="rules.select-theme" />',
				centered: true,
				modal: true,
				width: 500,
				height: 400,
				bodyContent: themes
			}).render();
		});
				
		function <portlet:namespace />saveRule(){
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "save_theme_rule";		
			submitForm(document.<portlet:namespace />fm);
		}		

 		A.one('#<portlet:namespace />saveRule').on('click', <portlet:namespace />saveRule);
	});


	Liferay.provide(
		window,
		'<portlet:namespace />deleteRule',
		function (deleteRuleId) {
			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "delete_theme_rule";		
			document.<portlet:namespace />fm.<portlet:namespace />deleteRuleId.value = deleteRuleId;
			submitForm(document.<portlet:namespace />fm);
		},
		['aui-base']
	);
 


	Liferay.provide(
		window,
		'<portlet:namespace />selectLookAndFeel',
		function(themeId, colorSchemeId, imageUrl, name) {
			var A = AUI();
			A.one('#<portlet:namespace />dynamicThemeId').setAttribute('value', themeId);
			A.one('#<portlet:namespace />dynamicColorSchemeId').setAttribute('value', colorSchemeId);
			A.one('#<portlet:namespace />selectedThemeImg').setAttribute('src', imageUrl);
			A.one('#<portlet:namespace />selectedThemeName').setContent(name);
		},
		['aui-base']
	);


</aui:script>

