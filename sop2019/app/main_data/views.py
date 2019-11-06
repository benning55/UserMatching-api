import urllib
import urllib.request
import json
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
            final_data = json.dumps(cls=MyEncoder, obj=result)
            data_a = get_company_a_data()
            # print(data_a)
            data_b = get_company_b_data()
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
    url = "http://192.168.1.37:8200/companya/"
    print("Test what is happen")
    context = {
        "Benning": "MUSE"
    }
    response = urllib.request.urlopen(url)
    data = json.loads(response.read())
    result = data[0]
    print(data)
    print(data[0])
    return Response(result, status=status.HTTP_200_OK)


def get_company_a_data():
    """Get the data from company A"""
    url = "http://192.168.1.37:8200/companya/"
    response = urllib.request.urlopen(url)
    data = json.loads(response.read())
    return data[0]


def get_company_b_data():
    """Get the data from company B"""
    url = "http://192.168.1.37:8200/companya/"
    response = urllib.request.urlopen(url)
    data = json.loads(response.read())
    return data[0]


