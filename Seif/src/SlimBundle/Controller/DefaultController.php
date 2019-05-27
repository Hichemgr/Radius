<?php

namespace SlimBundle\Controller;


use SlimBundle\Entity\Assisstance;
use SlimBundle\Entity\Assisstant;
use SlimBundle\Entity\Conseil;
use SlimBundle\Entity\Livraison;
use SlimBundle\Entity\Livreur;
use SlimBundle\Form\AssisstanceType;
use SlimBundle\Form\AssisstantType;
use SlimBundle\Form\CheckoutType;
use SlimBundle\Form\LivraisonType;
use SlimBundle\Form\LivreurType;
use SlimBundle\Repository\LivraisonRepository;
use SlimBundle\Repository\LivreurRepository;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use AppBundle\Entity\Notification;



class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Slim/Default/index.html.twig');
    }

    public function livraisonAction()
    {
        return $this->render('@Slim/Front/livraison.html.twig');
    }
    public function indexfrontAction()
    {
        return $this->render('@Slim/Default/indexfront.html.twig');
    }
    public function singlepostAction()
    {
        return $this->render('@Slim/Front/single-post.html.twig');
    }
    public function ajoutAssisstanceAction(Request $request)
    {
        $Assisstance = new Assisstance();

        $form = $this->createForm(AssisstanceType::class, $Assisstance);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Assisstance);
            $em->flush();
            return $this->redirectToRoute("ajoutAssisstance");
        }
        return $this->render("@Slim/Back/ajouterAssisstance.html.twig",
            array('Assisstance_form' => $form->createView()));
    }
    public function ajouterAssisstantAction(Request $request)
    {
        $Assisstant = new Assisstant();

        $form = $this->createForm(AssisstantType::class, $Assisstant);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Assisstant);
            $em->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/ajouterAssisstant.html.twig",
            array('Assisstant_form' => $form->createView()));
    }
    public function afficherAssisstantAction()
    {
        $proj = $this->getDoctrine()->getRepository(Assisstant::class)->findAll();
        $proj1 = $this->getDoctrine()->getRepository(Assisstance::class)->findAll();
        $proj2 = $this->getDoctrine()->getRepository(Conseil::class)->findAll();
        return $this->render("@Slim/Back/afficherAssisstant.html.twig", array('Assisstant'=>$proj,'Assisstance'=>$proj1,'Conseil'=>$proj2));
    }
    public function supprimerAssisstantAction($IdAssisstant)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Assisstant::class)->find($IdAssisstant);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }
    public function supprimerAssisstanceAction($idAssisstance)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Assisstance::class)->find($idAssisstance);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }
    public function supprimerConseilAction($idConseil)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Conseil::class)->find($idConseil);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }

    public function modifierAssisstantAction($IdAssisstant,Request $request){
        $cars=$this->getDoctrine()->getRepository(Assisstant::class)->find($IdAssisstant);
        $form=$this->createForm(AssisstantType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/modifierAssisstant.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function modifierAssisstanceAction($idAssisstance,Request $request){
        $cars=$this->getDoctrine()->getRepository(Assisstance::class)->find($idAssisstance);
        $form=$this->createForm(AssisstanceType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/modifierAssisstance.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function afficherLivraisonAction(Request $request)
    {$em=$this->getDoctrine()->getManager();
        $user = $this->getUser();
        $dql="select l from SlimBundle:Livraison l";
        $query=$em->createQuery($dql);
        /**
         * @var $paginator /Knp/Component/Pager/Paginator
         */
        $paginator=$this->get('knp_paginator');
        $result=$paginator->paginate($query,$request->query->getInt('page',1),$request->query->getInt('limit',6));
        dump(get_class($paginator));

        $dql1="select l from SlimBundle:Livreur l";
        $query1=$em->createQuery($dql1);
        /**
         * @var $paginator /Knp/Component/Pager/Paginator
         */
        $paginator=$this->get('knp_paginator');
        $result1=$paginator->paginate($query1,$request->query->getInt('page',1),$request->query->getInt('limit',3));
        dump(get_class($paginator));

        $proj = $this->getDoctrine()->getRepository(Livraison::class)->findAll();
        $proj1 = $this->getDoctrine()->getRepository(Livreur::class)->findAll();
        return $this->render("@Slim/Back/afficherLivraison.html.twig", array(
            "Livraison"=>$result,
            "Livreur"=>$result1,
            'user'=>$user
        ));
    }
    public function supprimerLivraisonAction($idLivraison)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Livraison::class)->find($idLivraison);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherLivraison");
    }
    public function modifierLivraisonAction($idLivraison,Request $request){
        $cars=$this->getDoctrine()->getRepository(Livraison::class)->find($idLivraison);
        $form=$this->createForm(LivraisonType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherLivraison");
        }
        return $this->render("@Slim/Back/modifierLivraison.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function afficherLivreurAction()
    {
        $livreur= $this->getDoctrine()->getRepository(Livreur::class)->findAll();
        return $this->render("@Slim/Back/afficherLivraison.html.twig", array(
                "Livreur"=> $livreur)

        );
    }
    public function supprimerLivreurAction($idLivreur)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Livreur::class)->find($idLivreur);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherLivraison");
    }
    public function modifierLivreurAction($idLivreur,Request $request){
        $cars=$this->getDoctrine()->getRepository(Livreur::class)->find($idLivreur);
        $form=$this->createForm(LivreurType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherLivraison");
        }
        return $this->render("@Slim/Back/modifierLivreur.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function ajouterLivreurAction(Request $request)
    {
        $Livreur = new Livreur();

        $form = $this->createForm(LivreurType::class, $Livreur);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Livreur);
            $em->flush();
            return $this->redirectToRoute("afficherLivraison");
        }
        return $this->render("@Slim/Back/ajouterLivreur.html.twig",
            array('Livreur_form' => $form->createView()));
    }
    public function ajouterLivraisonAction(Request $request)
    {
        $Livraison = new Livraison();
        $user = $this->getUser();
        //var_dump($user);

        $form = $this->createForm(CheckoutType::class, $Livraison);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $article=(new \DateTime('now'));
            if ($Livraison->getDate()>$article)
            {
                $em = $this->getDoctrine()->getManager();
                $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
                $idd= $this->getUser()->getId() ;

                $em->persist($Livraison);
                $em->flush();

                $notification = new Notification();
                $notification
                    ->setTitle("Livraison")
                    ->setDescription($Livraison->getNomclient())
                    ->setRoute('afficherLivraison');
                $em->persist($notification);
                $em->flush();

                $pusher = $this->get('mrad.pusher.notificaitons');
                $pusher->trigger($notification);


                return $this->redirectToRoute("afficherLivraison");
            }else{
                $this->get('session')->getFlashBag()->add(
                    'notice',
                    'Date invalide'
                );
            }

        }
        return $this->render("@Slim/Front/livraison.html.twig",
            array('Livraison_form' => $form->createView(),'user'=>$user));
    }
    public function afficherLivreurDispoAction($idLivraison,Request $request)
    {
        $livreur= $this->getDoctrine()->getRepository(Livreur::class)->findBy(['etat' => 0]);
        return $this->render("@Slim/Back/afficherLivraisonDispo.html.twig", array(
                "Livreur"=> $livreur,"idLivraison"=>$idLivraison)

        );
    }
    public function AffecterLivreurLivraisonAction($idLivraison,$nomLivreur)
    {
        $result=$this->getDoctrine()->getManager()->createQuery("UPDATE SlimBundle:Livraison l SET l.nomlivreur='".$nomLivreur."', l.etat=1 WHERE l.idLivraison=".$idLivraison."")->getResult();
        $result=$this->getDoctrine()->getManager()->createQuery("UPDATE SlimBundle:Livreur l SET l.etat=1 WHERE l.nom='".$nomLivreur."'")->getResult();
        return $this->redirectToRoute("afficherLivraison");
    }
    public function TerminerLivraisonAction($idLivraison,$nomLivreur)
    {
        $result=$this->getDoctrine()->getManager()->createQuery("UPDATE SlimBundle:Livraison l SET l.nomlivreur='', l.etat=2 WHERE l.idLivraison=".$idLivraison."")->getResult();
        $this->getDoctrine()->getManager()->createQuery("UPDATE SlimBundle:Livreur l SET l.etat=0 WHERE l.nom='".$nomLivreur."'")->getResult();
        return $this->redirectToRoute("afficherLivraison");
    }


    /**
     * @Route("/calendar", name="booking_calendar")
     */
    public function calendarAction()
    {
        return $this->render('@Slim/Back/calendar.html.twig');
    }

    public function mesLivraisonsAction()
    {
        $user = $this->getUser();
        $this->denyAccessUnlessGranted("IS_AUTHENTICATED_FULLY");
        $idd= $this->getUser()->getUsername();
        $proj = $this->getDoctrine()->getRepository(Livraison::class)->findBy(['nomclient' => $idd]);
        return $this->render("@Slim/Front/mesLivraisons.html.twig", array(
            "Livraison"=>$proj,
            'user'=>$user
        ));
    }

    public function displayAction()
    {
        $notifications = $this->getDoctrine()->getManager()->getRepository('AppBundle:Notification')->findAll();
        return $this->render('@Slim/Back/afficherLivraison.html.twig',array(
            'notifications' => $notifications
        ));
    }




}
