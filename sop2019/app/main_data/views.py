import urllib
import urllib.request
import json
import requests
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view, permission_classes
from rest_framework.permissions import AllowAny
from main_data.serializers import PersonSerializer
from json import JSONEncoder
# Create your views here.


class MyEncoder(JSONEncoder):
    def default(self, o):
        return o.__dict__


@api_view(['POST', ])
@permission_classes([AllowAny, ])
def person_view(request):
    """To start recieving data"""
    if request.method == 'POST':
        serializer = PersonSerializer(data=request.data)
        if serializer.is_valid():
            result = serializer.create(validated_data=request.data)
            print(f'{result.first_name} {result.last_name}')
            # final_data = json.dumps(cls=MyEncoder, obj=result)
            data_a = get_company_a_data(result.first_name, result.last_name)
            data_b = get_company_b_data(result.first_name, result.last_name)
            payload = {
                'companyA': data_a,
                'companyB': data_b
            }
            return Response(payload, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', ])
@permission_classes([AllowAny, ])
def companya_data(request):
    """Look at company a data"""
    url = "http://10.110.198.242:8200/companya/search-person/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Test what is happen")
    payload = {
        "first_name": "ben",
        "last_name": "maisonti"
    }
    res = requests.post(url, json=payload, headers=headers)
    print(res.json())
    return Response(res.json(), status=status.HTTP_200_OK)


def get_company_a_data(first_name, last_name):
    """Get the data from company A"""
    url = "http://10.110.198.242:8200/companya/search-person/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Company A data is Okay")
    payload = {
        "first_name": first_name,
        "last_name": last_name
    }
    res = requests.post(url, json=payload, headers=headers)
    return res.json()


def get_company_b_data(first_name, last_name):
    """Get the data from company B"""
    url = "http://10.110.198.242:8202/companyb/search-person/"
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    print("Company B data is Okay")
    payload = {
        "fname": first_name,
        "lname": last_name
    }
    res = requests.post(url, json=payload, headers=headers)
    return res.json()
