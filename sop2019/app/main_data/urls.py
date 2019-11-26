from django.urls import path
from main_data.views import person_view, companya_data, result_data
from main_data.tests import chesse

urlpatterns = [
    path('person-request/', person_view, name="person_view"),
    path('companya-data/', companya_data, name="companya"),
    path('result-data/', result_data, name="result_data")
]
