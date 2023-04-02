This XML file does not appear to have any style information associated with it. The document tree is shown below.
<con:soapui-project xmlns:con="http://eviware.com/soapui/config" id="d2228a8a-c538-44b3-a392-788bab7199f6" activeEnvironment="Default" name="REST Project 1" resourceRoot="" soapui-version="5.7.0" abortOnError="false" runType="SEQUENTIAL">
<con:settings/>
<con:interface xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="con:RestService" id="b440127a-95fd-40b3-b737-0b3d1039a7c7" wadlVersion="http://wadl.dev.java.net/2009/02" name="http://localhost:8080" type="rest">
<con:settings/>
<con:definitionCache type="TEXT" rootPart=""/>
<con:endpoints>
<con:endpoint>http://LAPTOP-Alexander:8089/</con:endpoint>
<con:endpoint>http://localhost:8080</con:endpoint>
</con:endpoints>
<con:resource name="Topjava MealsDelete" path="/topjava/rest/meals/100003" id="69494e4d-2eaf-4027-9292-d48e1eb7ad63">
<con:settings/>
<con:parameters/>
<con:method name="Method 1" id="f12f6517-c8a6-4949-bec6-5f382410faf3" method="DELETE">
<con:settings/>
<con:parameters/>
<con:representation type="FAULT">
<con:mediaType>text/html;charset=utf-8</con:mediaType>
<con:status>404 500</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/json</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:request name="Delete" id="c06abfef-ca27-411c-af30-c625f74ab642" mediaType="application/json" postQueryString="false">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request/>
<con:originalUri>http://localhost/topjava/rest/admin</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters/>
</con:request>
</con:method>
</con:resource>
<con:resource name="Topjava MealsGetAll" path="/topjava/rest/meals" id="696bb70d-d373-40c2-8b65-882b7b577f41">
<con:settings/>
<con:parameters/>
<con:method name="Topjava" id="cc031362-4beb-4eb5-adf2-437fea41f4f6" method="GET">
<con:settings/>
<con:parameters/>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:representation type="FAULT">
<con:mediaType>text/html;charset=utf-8</con:mediaType>
<con:status>404 400 405</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/json</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:request name="MealsGetAll" id="0199f7a6-1bff-47d6-8012-8823a774e370" mediaType="application/json" postQueryString="false">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request/>
<con:originalUri>http://localhost/topjava/rest/admin/users</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters/>
<con:parameterOrder/>
</con:request>
</con:method>
</con:resource>
<con:resource name="Topjava MealsUpdate" path="/topjava/rest/meals/100006" id="696bb70d-d373-40c2-8b65-882b7b577f41">
<con:settings/>
<con:parameters/>
<con:method name="Topjava" id="cc031362-4beb-4eb5-adf2-437fea41f4f6" method="PUT">
<con:settings/>
<con:parameters/>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:representation type="FAULT">
<con:mediaType>text/html;charset=utf-8</con:mediaType>
<con:status>404 400 405 500</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/json</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:request name="Update" id="0199f7a6-1bff-47d6-8012-8823a774e370" mediaType="application/json" postQueryString="false">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request/>
<con:originalUri>http://localhost/topjava/rest/admin/users</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters/>
<con:parameterOrder/>
</con:request>
</con:method>
</con:resource>
<con:resource name="Topjava MealsCreate" path="/topjava/rest/meals/create" id="696bb70d-d373-40c2-8b65-882b7b577f41">
<con:settings/>
<con:parameters/>
<con:method name="Topjava" id="cc031362-4beb-4eb5-adf2-437fea41f4f6" method="PUT">
<con:settings/>
<con:parameters/>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:representation type="FAULT">
<con:mediaType>text/html;charset=utf-8</con:mediaType>
<con:status>404 400 405</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/json</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:request name="Create" id="0199f7a6-1bff-47d6-8012-8823a774e370" mediaType="application/json" postQueryString="false">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request/>
<con:originalUri>http://localhost/topjava/rest/admin/users</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters/>
<con:parameterOrder/>
</con:request>
</con:method>
</con:resource>
<con:resource name="Topjava MealsPostUpdate" path="/topjava/rest/meals/100006" id="696bb70d-d373-40c2-8b65-882b7b577f41">
<con:settings/>
<con:parameters/>
<con:method name="Topjava" id="cc031362-4beb-4eb5-adf2-437fea41f4f6" method="PUT">
<con:settings/>
<con:parameters/>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200 201</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:representation type="FAULT">
<con:mediaType>text/html;charset=utf-8</con:mediaType>
<con:status>404 400 405 500</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/json</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:request name="PutUpdate" id="0199f7a6-1bff-47d6-8012-8823a774e370" mediaType="application/json" postQueryString="false">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:encoding>UTF-8</con:encoding>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request>{ "id": 100006, "dateTime": "2020-01-31T01:01:00", "description": "Еда на граничное значение 2", "calories": 100 }</con:request>
<con:originalUri>http://localhost/topjava/rest/admin/users</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters/>
<con:parameterOrder/>
</con:request>
</con:method>
</con:resource>
<con:resource name="Topjava MealsPostCreate" path="/topjava/rest/meals" id="696bb70d-d373-40c2-8b65-882b7b577f41">
<con:settings/>
<con:parameters/>
<con:method name="Topjava" id="cc031362-4beb-4eb5-adf2-437fea41f4f6" method="POST">
<con:settings/>
<con:parameters/>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200 201</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:representation type="FAULT">
<con:mediaType>text/html;charset=utf-8</con:mediaType>
<con:status>404 400 405 415 500</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/json</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="REQUEST">
<con:mediaType>application/x-www-form-urlencoded</con:mediaType>
<con:params/>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>0</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType xsi:nil="true"/>
<con:status>204</con:status>
<con:params/>
<con:element>data</con:element>
</con:representation>
<con:request name="PostCreate" id="0199f7a6-1bff-47d6-8012-8823a774e370" mediaType="application/json" postQueryString="false">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:encoding>UTF-8</con:encoding>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request>{ "dateTime": "2020-01-31T01:03:11", "description": "Еда новая", "calories": 100 }</con:request>
<con:originalUri>http://localhost/topjava/rest/admin/users</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters/>
<con:parameterOrder/>
</con:request>
</con:method>
</con:resource>
<con:resource name="filter" path="/topjava/rest/meals/filter" id="e94479f7-4501-474d-aea3-f15d84e1fe1c">
<con:settings/>
<con:parameters>
<con:parameter>
<con:name>startDate</con:name>
<con:value/>
<con:style>QUERY</con:style>
<con:default/>
<con:description xsi:nil="true"/>
</con:parameter>
<con:parameter>
<con:name>startTime</con:name>
<con:value/>
<con:style>QUERY</con:style>
<con:default/>
<con:description xsi:nil="true"/>
</con:parameter>
<con:parameter>
<con:name>endDate</con:name>
<con:value/>
<con:style>QUERY</con:style>
<con:default/>
<con:description xsi:nil="true"/>
</con:parameter>
<con:parameter>
<con:name>endTime</con:name>
<con:value/>
<con:style>QUERY</con:style>
<con:default/>
<con:description xsi:nil="true"/>
</con:parameter>
</con:parameters>
<con:method name="filter" id="da9d76e2-3632-441e-a07c-e75e710b4d9f" method="GET">
<con:settings/>
<con:parameters/>
<con:representation type="RESPONSE">
<con:mediaType>text/html; charset=iso-8859-1</con:mediaType>
<con:status>200</con:status>
<con:params/>
<con:element>html</con:element>
</con:representation>
<con:representation type="RESPONSE">
<con:mediaType>application/json;charset=UTF-8</con:mediaType>
<con:status>200</con:status>
<con:params/>
<con:element>Response</con:element>
</con:representation>
<con:request name="filter" id="b73c87bf-01f4-42b8-8461-e3899b3246c7" mediaType="application/json">
<con:settings>
<con:setting id="com.eviware.soapui.impl.wsdl.WsdlRequest@request-headers"><xml-fragment/></con:setting>
</con:settings>
<con:endpoint>http://localhost:8080</con:endpoint>
<con:request/>
<con:originalUri>http://LAPTOP-Alexander/topjava/rest/meals/filter</con:originalUri>
<con:credentials>
<con:authType>No Authorization</con:authType>
</con:credentials>
<con:jmsConfig JMSDeliveryMode="PERSISTENT"/>
<con:jmsPropertyConfig/>
<con:parameters>
<con:entry key="endDate" value="2020-01-31"/>
<con:entry key="startTime" value="07:00:00"/>
<con:entry key="endTime" value="11:00:00"/>
<con:entry key="startDate" value="2020-01-30"/>
</con:parameters>
<con:parameterOrder>
<con:entry>startDate</con:entry>
<con:entry>startTime</con:entry>
<con:entry>endDate</con:entry>
<con:entry>endTime</con:entry>
</con:parameterOrder>
</con:request>
</con:method>
</con:resource>
</con:interface>
<con:restMockService id="bc999e6b-a657-4adf-b42b-b4a98ffa6448" port="8080" path="/" host="LAPTOP-Alexander">
<con:settings/>
<con:properties/>
</con:restMockService>
<con:properties/>
<con:wssContainer/>
<con:oAuth2ProfileContainer/>
<con:oAuth1ProfileContainer/>
<con:sensitiveInformation/>
</con:soapui-project>