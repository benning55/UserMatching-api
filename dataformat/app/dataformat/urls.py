from django.urls import path
from dataformat.views import format_data

urlpatterns = [
    path('data-format/', format_data, name="format_data"),
]
