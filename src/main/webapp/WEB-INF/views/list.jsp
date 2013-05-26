<div from="Lars" greet="Alexandra"></div>
<form class="form-search">
	<div class="input-append">
		<input type="text" ng-model="query" class="input-medium search-query"
			placeholder="Search">
		<button ng-click="reset()" type="submit" class="btn">
			<i class="icon-search"></i>
		</button>
	</div>
	<button ng-click="query=''; reset()" ng-disabled="!query" type="submit"
		class="btn">Reset</button>
</form>
<table
	class="table table-striped table-bordered table-condensed table-hover">
	<thead>
		<th sorted="name">name</th>
		<th sorted="email">email</th>
		<th sorted="country">country</th>
		<th sorted="postalCode">postal code</th>
		<th sorted="ts">date</th>
	</thead>
	<tbody>
		<tr ng-repeat="people in peoples.content">
			<td>{{people.name}}</td>
			<td>{{people.email}}</td>
			<td>{{people.country}}</td>
			<td>{{people.postalCode}}</td>
			<td>{{people.ts | date:'EEE dd.MM.yyyy, hh:mm a'}}</td>
		</tr>
	</tbody>
</table>
{{has_more()}} {{has_less()}} {{less}}
<ul class="pager">
	<li class="previous {{has_less()}}" ng-click="show_previous()"><span>previous</span></li>
	<li><span>{{peoples.page.number}}/{{peoples.page.totalPages}}
			= {{peoples.page.totalElements}} Elements</span></li>
	<li class="next {{has_more()}}" ng-click="show_next()"><span>next</span></li>
</ul>
